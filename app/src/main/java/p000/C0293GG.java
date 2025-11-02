package p000;

/* loaded from: classes.dex */
public final class C0293GG implements InterfaceC0155DG {

    public static final AbstractC2001lA f874A;

    public static final AbstractC2001lA f875B;

    public static final AbstractC2001lA f876C;

    public static final AbstractC2001lA f877D;

    public static final AbstractC2001lA f878E;

    public static final AbstractC2001lA f879F;

    public static final AbstractC2001lA f880G;

    public static final AbstractC2001lA f881H;

    public static final AbstractC2001lA f882I;

    public static final AbstractC2001lA f883J;

    public static final AbstractC2001lA f884K;

    public static final AbstractC2001lA f885L;

    public static final AbstractC2001lA f886M;

    public static final AbstractC2001lA f887N;

    public static final AbstractC2001lA f888O;

    public static final AbstractC2001lA f889P;

    public static final AbstractC2001lA f890Q;

    public static final AbstractC2001lA f891R;

    public static final AbstractC2001lA f892S;

    public static final AbstractC2001lA f893T;

    public static final AbstractC2001lA f894U;

    public static final AbstractC2001lA f895V;

    public static final AbstractC2001lA f896W;

    public static final AbstractC2001lA f897X;

    public static final AbstractC2001lA f898Y;

    public static final AbstractC2001lA f899Z;

    public static final AbstractC2001lA f900a;

    public static final AbstractC2001lA f901a0;

    public static final AbstractC2001lA f902b;

    public static final AbstractC2001lA f903b0;

    public static final AbstractC2001lA f904c;

    public static final AbstractC2001lA f905c0;

    public static final AbstractC2001lA f906d;

    public static final AbstractC2001lA f907e;

    public static final AbstractC2001lA f908f;

    public static final AbstractC2001lA f909g;

    public static final AbstractC2001lA f910h;

    public static final AbstractC2001lA f911i;

    public static final AbstractC2001lA f912j;

    public static final AbstractC2001lA f913k;

    public static final AbstractC2001lA f914l;

    public static final AbstractC2001lA f915m;

    public static final AbstractC2001lA f916n;

    public static final AbstractC2001lA f917o;

    public static final AbstractC2001lA f918p;

    public static final AbstractC2001lA f919q;

    public static final AbstractC2001lA f920r;

    public static final AbstractC2001lA f921s;

    public static final AbstractC2001lA f922t;

    public static final AbstractC2001lA f923u;

    public static final AbstractC2001lA f924v;

    public static final AbstractC2001lA f925w;

    public static final AbstractC2001lA f926x;

    public static final AbstractC2001lA f927y;

    public static final AbstractC2001lA f928z;

    static {
        C0057BA c0057baM220e = new C0057BA(AbstractC1721fA.m7566a("com.google.android.gms.measurement")).m221f().m220e();
        f900a = c0057baM220e.m217b("measurement.ad_id_cache_time", 10000L);
        f902b = c0057baM220e.m217b("measurement.app_uninstalled_additional_ad_id_cache_time", 3600000L);
        f904c = c0057baM220e.m219d("measurement.config.bundle_for_all_apps_on_backgrounded", true);
        f906d = c0057baM220e.m217b("measurement.max_bundles_per_iteration", 100L);
        f907e = c0057baM220e.m217b("measurement.config.cache_time", 86400000L);
        c0057baM220e.m218c("measurement.log_tag", "FA");
        c0057baM220e.m217b("measurement.id.config.experiment_id", 0L);
        f908f = c0057baM220e.m218c("measurement.config.url_authority", "app-measurement.com");
        f909g = c0057baM220e.m218c("measurement.config.url_scheme", "https");
        f910h = c0057baM220e.m217b("measurement.upload.debug_upload_interval", 1000L);
        f911i = c0057baM220e.m217b("measurement.session.engagement_interval", 3600000L);
        f912j = c0057baM220e.m218c("measurement.rb.attribution.event_params", "value|currency");
        c0057baM220e.m217b("measurement.id.rb.attribution.app_allowlist", 0L);
        f913k = c0057baM220e.m217b("measurement.upload.google_signal_max_queue_time", 605000L);
        f914l = c0057baM220e.m218c("measurement.sgtm.google_signal.url", "https://app-measurement.com/s");
        f915m = c0057baM220e.m217b("measurement.lifetimevalue.max_currency_tracked", 4L);
        f916n = c0057baM220e.m217b("measurement.dma_consent.max_daily_dcu_realtime_events", 1L);
        f917o = c0057baM220e.m217b("measurement.upload.max_event_parameter_value_length", 100L);
        f918p = c0057baM220e.m217b("measurement.store.max_stored_events_per_app", 100000L);
        f919q = c0057baM220e.m217b("measurement.experiment.max_ids", 50L);
        f920r = c0057baM220e.m217b("measurement.audience.filter_result_max_count", 200L);
        f921s = c0057baM220e.m217b("measurement.upload.max_item_scoped_custom_parameters", 27L);
        f922t = c0057baM220e.m217b("measurement.rb.attribution.client.min_ad_services_version", 7L);
        f923u = c0057baM220e.m217b("measurement.alarm_manager.minimum_interval", 60000L);
        f924v = c0057baM220e.m217b("measurement.upload.minimum_delay", 500L);
        f925w = c0057baM220e.m217b("measurement.monitoring.sample_period_millis", 86400000L);
        f926x = c0057baM220e.m219d("measurement.config.notify_trigger_uris_on_backgrounded", true);
        f927y = c0057baM220e.m218c("measurement.rb.attribution.app_allowlist", "com.labpixies.flood,com.sofascore.results,games.spearmint.triplecrush,com.block.juggle,io.supercent.linkedcubic,com.cdtg.gunsound,com.corestudios.storemanagementidle,com.cdgames.fidget3d,io.supercent.burgeridle,io.supercent.pizzaidle,jp.ne.ibis.ibispaintx.app,com.dencreak.dlcalculator,com.ebay.kleinanzeigen,de.wetteronline.wetterapp,com.game.shape.shift,com.champion.cubes,bubbleshooter.orig,com.wolt.android,com.master.hotelmaster,com.games.bus.arrival,com.playstrom.dop2,com.huuuge.casino.slots,com.ig.spider.fighting,com.jura.coloring.page,com.rikkogame.ragdoll2,com.ludo.king,com.sigma.prank.sound.haircut,com.crazy.block.robo.monster.cliffs.craft,com.fugo.wow,com.maps.locator.gps.gpstracker.phone,com.gamovation.tileclub,com.pronetis.ironball2,com.meesho.supply,pdf.pdfreader.viewer.editor.free,com.dino.race.master,com.ig.moto.racing,ai.photo.enhancer.photoclear,com.duolingo,com.candle.magic_piano,com.free.vpn.super.hotspot.open,sg.bigo.live,com.cdg.tictactoe,com.zhiliaoapp.musically.go,com.wildspike.wormszone,com.mast.status.video.edit,com.vyroai.photoeditorone,com.pujiagames.deeeersimulator,com.superbinogo.jungleboyadventure,com.trustedapp.pdfreaderpdfviewer,com.artimind.aiart.artgenerator.artavatar,de.cellular.ottohybrid,com.zeptolab.cats.google,in.crossy.daily_crossword");
        f928z = c0057baM220e.m217b("measurement.upload.realtime_upload_interval", 10000L);
        f874A = c0057baM220e.m217b("measurement.upload.refresh_blacklisted_config_interval", 604800000L);
        c0057baM220e.m217b("measurement.config.cache_time.service", 3600000L);
        f875B = c0057baM220e.m217b("measurement.service_client.idle_disconnect_millis", 5000L);
        c0057baM220e.m218c("measurement.log_tag.service", "FA-SVC");
        f876C = c0057baM220e.m218c("measurement.sgtm.app_allowlist", "de.zalando.mobile.internal,de.zalando.mobile.internal.debug,de.zalando.lounge.dev,grit.storytel.app,com.rbc.mobile.android,com.rbc.mobile.android,com.dylvian.mango.activities,com.home24.android,com.home24.android.staging,se.lf.mobile.android,se.lf.mobile.android.beta,se.lf.mobile.android.rc,se.lf.mobile.android.test,se.lf.mobile.android.test.debug,com.boots.flagship.android,com.boots.flagshiproi.android,de.zalando.mobile,com.trivago,com.getyourguide.android,es.mobail.meliarewards,se.nansen.coop.debug,se.nansen.coop,se.coop.coop.qa,com.booking,com.google.firebaseengage,com.mse.mseapp.dev,com.mse.mseapp,pl.eobuwie.eobuwieapp,br.com.eventim.mobile.app.Android,ch.ticketcorner.mobile.app.Android,de.eventim.mobile.app.Android,dk.billetlugen.mobile.app.Android,nl.eventim.mobile.app.Android,com.asos.app,com.blueshieldca.prod,dk.magnetix.tivoliapp,matas.matas.internal,nl.omoda,com.thetrainline,com.simo.androidtest,de.aboutyou.mobile.app,com.hometogo,de.casamundo.casamundomobile,it.casevacanz,eu.coolblue.shop,com.stihl.app,com.indeed.android.jobsearch,com.homeretailgroup.argos.android,com.dylvian.mango.activities.pre,se.nansen.coop.qa");
        f877D = c0057baM220e.m217b("measurement.upload.stale_data_deletion_interval", 86400000L);
        f878E = c0057baM220e.m218c("measurement.rb.attribution.uri_authority", "google-analytics.com");
        f879F = c0057baM220e.m217b("measurement.rb.attribution.max_queue_time", 1209600000L);
        f880G = c0057baM220e.m218c("measurement.rb.attribution.uri_path", "privacy-sandbox/register-app-conversion");
        f881H = c0057baM220e.m218c("measurement.rb.attribution.query_parameters_to_remove", "");
        f882I = c0057baM220e.m218c("measurement.rb.attribution.uri_scheme", "https");
        f883J = c0057baM220e.m217b("measurement.sdk.attribution.cache.ttl", 604800000L);
        f884K = c0057baM220e.m217b("measurement.redaction.app_instance_id.ttl", 7200000L);
        f885L = c0057baM220e.m217b("measurement.upload.backoff_period", 43200000L);
        f886M = c0057baM220e.m217b("measurement.upload.initial_upload_delay_time", 15000L);
        f887N = c0057baM220e.m217b("measurement.upload.interval", 3600000L);
        f888O = c0057baM220e.m217b("measurement.upload.max_bundle_size", 65536L);
        f889P = c0057baM220e.m217b("measurement.upload.max_bundles", 100L);
        f890Q = c0057baM220e.m217b("measurement.upload.max_conversions_per_day", 500L);
        f891R = c0057baM220e.m217b("measurement.upload.max_error_events_per_day", 1000L);
        f892S = c0057baM220e.m217b("measurement.upload.max_events_per_bundle", 1000L);
        f893T = c0057baM220e.m217b("measurement.upload.max_events_per_day", 100000L);
        f894U = c0057baM220e.m217b("measurement.upload.max_public_events_per_day", 50000L);
        f895V = c0057baM220e.m217b("measurement.upload.max_queue_time", 2419200000L);
        f896W = c0057baM220e.m217b("measurement.upload.max_realtime_events_per_day", 10L);
        f897X = c0057baM220e.m217b("measurement.upload.max_batch_size", 65536L);
        f898Y = c0057baM220e.m217b("measurement.upload.retry_count", 6L);
        f899Z = c0057baM220e.m217b("measurement.upload.retry_time", 1800000L);
        f901a0 = c0057baM220e.m218c("measurement.upload.url", "https://app-measurement.com/a");
        f903b0 = c0057baM220e.m217b("measurement.upload.window_interval", 3600000L);
        f905c0 = c0057baM220e.m218c("measurement.rb.attribution.user_properties", "_npa,npa");
    }

    @Override
    public final String mo635A() {
        return (String) f878E.m8368b();
    }

    @Override
    public final long mo636B() {
        return ((Long) f928z.m8368b()).longValue();
    }

    @Override
    public final long mo637C() {
        return ((Long) f892S.m8368b()).longValue();
    }

    @Override
    public final long mo638D() {
        return ((Long) f875B.m8368b()).longValue();
    }

    @Override
    public final String mo639E() {
        return (String) f881H.m8368b();
    }

    @Override
    public final long mo640F() {
        return ((Long) f894U.m8368b()).longValue();
    }

    @Override
    public final String mo641G() {
        return (String) f901a0.m8368b();
    }

    @Override
    public final long mo642H() {
        return ((Long) f922t.m8368b()).longValue();
    }

    @Override
    public final long mo643I() {
        return ((Long) f896W.m8368b()).longValue();
    }

    @Override
    public final long mo644J() {
        return ((Long) f924v.m8368b()).longValue();
    }

    @Override
    public final long mo645K() {
        return ((Long) f898Y.m8368b()).longValue();
    }

    @Override
    public final long mo646L() {
        return ((Long) f885L.m8368b()).longValue();
    }

    @Override
    public final long mo647M() {
        return ((Long) f903b0.m8368b()).longValue();
    }

    @Override
    public final String mo648N() {
        return (String) f905c0.m8368b();
    }

    @Override
    public final long mo649O() {
        return ((Long) f920r.m8368b()).longValue();
    }

    @Override
    public final String mo650P() {
        return (String) f909g.m8368b();
    }

    @Override
    public final boolean mo651Q() {
        return ((Boolean) f926x.m8368b()).booleanValue();
    }

    @Override
    public final long mo652R() {
        return ((Long) f887N.m8368b()).longValue();
    }

    @Override
    public final long mo653S() {
        return ((Long) f877D.m8368b()).longValue();
    }

    @Override
    public final String mo654T() {
        return (String) f914l.m8368b();
    }

    @Override
    public final long mo655U() {
        return ((Long) f889P.m8368b()).longValue();
    }

    @Override
    public final long mo656V() {
        return ((Long) f883J.m8368b()).longValue();
    }

    @Override
    public final String mo657W() {
        return (String) f876C.m8368b();
    }

    @Override
    public final long mo658X() {
        return ((Long) f891R.m8368b()).longValue();
    }

    @Override
    public final String mo659Y() {
        return (String) f880G.m8368b();
    }

    @Override
    public final long mo660Z() {
        return ((Long) f925w.m8368b()).longValue();
    }

    @Override
    public final long mo661a() {
        return ((Long) f900a.m8368b()).longValue();
    }

    @Override
    public final long mo662a0() {
        return ((Long) f893T.m8368b()).longValue();
    }

    @Override
    public final long mo663b() {
        return ((Long) f902b.m8368b()).longValue();
    }

    @Override
    public final String mo664b0() {
        return (String) f882I.m8368b();
    }

    @Override
    public final long mo665c() {
        return ((Long) f906d.m8368b()).longValue();
    }

    @Override
    public final long mo666c0() {
        return ((Long) f874A.m8368b()).longValue();
    }

    @Override
    public final long mo667d() {
        return ((Long) f907e.m8368b()).longValue();
    }

    @Override
    public final long mo668e() {
        return ((Long) f916n.m8368b()).longValue();
    }

    @Override
    public final long mo669f() {
        return ((Long) f910h.m8368b()).longValue();
    }

    @Override
    public final long mo670g() {
        return ((Long) f917o.m8368b()).longValue();
    }

    @Override
    public final long mo671h() {
        return ((Long) f911i.m8368b()).longValue();
    }

    @Override
    public final long mo672i() {
        return ((Long) f915m.m8368b()).longValue();
    }

    @Override
    public final long mo673j() {
        return ((Long) f913k.m8368b()).longValue();
    }

    @Override
    public final long mo674k() {
        return ((Long) f895V.m8368b()).longValue();
    }

    @Override
    public final long mo675l() {
        return ((Long) f919q.m8368b()).longValue();
    }

    @Override
    public final long mo676m() {
        return ((Long) f918p.m8368b()).longValue();
    }

    @Override
    public final long mo677n() {
        return ((Long) f921s.m8368b()).longValue();
    }

    @Override
    public final long mo678o() {
        return ((Long) f897X.m8368b()).longValue();
    }

    @Override
    public final long mo679p() {
        return ((Long) f923u.m8368b()).longValue();
    }

    @Override
    public final long mo680q() {
        return ((Long) f899Z.m8368b()).longValue();
    }

    @Override
    public final String mo681r() {
        return (String) f908f.m8368b();
    }

    @Override
    public final boolean mo682s() {
        return ((Boolean) f904c.m8368b()).booleanValue();
    }

    @Override
    public final long mo683t() {
        return ((Long) f886M.m8368b()).longValue();
    }

    @Override
    public final long mo684u() {
        return ((Long) f879F.m8368b()).longValue();
    }

    @Override
    public final String mo685v() {
        return (String) f912j.m8368b();
    }

    @Override
    public final long mo686w() {
        return ((Long) f888O.m8368b()).longValue();
    }

    @Override
    public final long mo687x() {
        return ((Long) f884K.m8368b()).longValue();
    }

    @Override
    public final String mo688y() {
        return (String) f927y.m8368b();
    }

    @Override
    public final long mo689z() {
        return ((Long) f890Q.m8368b()).longValue();
    }
}
